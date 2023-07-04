//HTML DOM 기반의 JS 코드 시작점
document.addEventListener("DOMContentLoaded", () => {
  const INDEX = {
    ID: 0,
    NAME: 1,
    TEL: 2,
    ADDR: 3,
  };

  // JS의 false 판별
  // null, undefined, "", 0, NaN( Not a Number )
  // const 변수 = 변수1 || 변수2 || 변수3
  // 변수1 값이 true이면 대입 false 이면 변수2 대입, 변수2가 false이면 변수3 대입
  const form_addr =
    document.querySelector("form.main.input") ||
    document.querySelector("form.main.update");
  const input_id = form_addr?.querySelector("input[name='a_id']");

  const input_name = document.querySelector("input[name='a_name']");
  const input_tel = document.querySelector("input[name='a_tel']");
  const input_addr = document.querySelector("input[name='a_addr']");

  const btn_input = document?.querySelector("button.input");
  const btn_list = document?.querySelector("button.list");

  const msg_boxs = document.querySelectorAll("div.message");
  // 2개의 매개변수를 받는 함수 선언
  const message_view = (index, className, message) => {
    const msg_box = msg_boxs[index];
    msg_box?.classList.remove("ok");
    msg_box?.classList.remove("error");

    msg_box?.classList.add(className);
    msg_box.querySelector("span").innerHTML = message;
  };

  btn_list?.addEventListener("click", (e) => {
    // alert("리스트 버튼 클릭");
    document.location.href = `${rootPath}`;
  });

  const inputButtonClickHandler = (e) => {
    for (let i = 0; i < msg_boxs.length; i++) {
      msg_boxs[i].classList.remove("ok");
      msg_boxs[i].classList.remove("error");
    }
    if (input_id && !input_id.value) {
      // const msg_box = msg_boxs[INDEX.ID];
      // msg_box.classList.remove("ok");
      // msg_box.classList.add("error");
      // msg_box.querySelector("span").innerHTML =
      //   "* ID는 반드시 입력해야 합니다.";
      message_view(INDEX.ID, "error", "* ID는 반드시 입력해야 합니다.");
      input_id.focus();
      return false;
    }
    if (!input_name.value) {
      message_view(INDEX.NAME, "error", "* 이름은 반드시 입력해야 합니다.");
      input_name.focus();
      return false;
    }
    if (!input_tel.value) {
      message_view(INDEX.TEL, "error", "* 전화번호는 반드시 입력해야 합니다.");
      input_tel.focus();
      return false;
    }
    const tel_rexp = /^\d{3}-\d{3,4}-\d{4}$/;
    if (!tel_rexp.test(input_tel.value)) {
      message_view(
        INDEX.TEL,
        "error",
        "* 전화번호 형식이 틀립니다. ex)000-0000-0000"
      );
      input_tel.focus();
      input_tel.select();
      return false;
    }

    if (!input_addr.value) {
      message_view(INDEX.ADDR, "error", "* 주소는 반드시 입력해야 합니다.");
      input_addr.focus();
      return false;
    }

    // alert("추가 버튼 클릭");
    if (confirm("저장할까요?")) {
      form_addr?.submit();
    }
  };
  btn_input?.addEventListener("click", inputButtonClickHandler);

  input_id?.addEventListener("blur", async (e) => {
    const value = e.target.value;
    // const span_box = msg_box.querySelector("span");
    const idcheck_url = `${rootPath}/id_check?id=${value}`;

    if (!value) {
      message_view(INDEX.ID, "error", "* ID를 입력해주세요.");
      input_id.focus();
      return false;
    }

    const respnse = await fetch(idcheck_url);
    const result = await respnse.text();
    if (result === "OK") {
      message_view(INDEX.ID, "ok", "* 사용가능한 ID 입니다");
    } else if (result === "FAIL") {
      message_view(INDEX.ID, "error", "* 사용중인 ID 입니다");
      input_id.focus();
    } else {
      message_view(INDEX.ID, "error", "* 서버오류!");
      input_id.focus();
    }
  });
});
