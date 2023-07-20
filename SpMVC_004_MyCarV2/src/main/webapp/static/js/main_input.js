const ERROR_MESSAGE = {
  CARNUM: "* 차량번호를 입력하세요",
  QTY: "* 업무구분을 입력하세요",
  USERNAME: "* 사용자를 입력하세요",
  SDATE: "* 시작일자를 입력하세요",
  STIME: "* 시작시간을 입력하세요",
  SKM: "* 출발 Km를 입력하세요",
};
document.addEventListener("DOMContentLoaded", () => {
  const input_carnum = document.querySelector("#c_carnum");
  const input_qty = document.querySelector("#c_qty");
  const input_username = document.querySelector("#c_username");
  const input_sdate = document.querySelector("#c_sdate");
  const input_stime = document.querySelector("#c_stime");
  const input_skm = document.querySelector("#c_skm");

  const btn_save = document.querySelector("#btn_save");

  const error_err_box_list = document.querySelectorAll("div.error");
  const error_carnum = document.querySelector("div.error.c_carnum");
  const error_qty = document.querySelector("div.error.c_qty");
  const error_username = document.querySelector("div.error.c_username");
  const error_sdate = document.querySelector("div.error.c_sdate");
  const error_stime = document.querySelector("div.error.c_stime");
  const error_skm = document.querySelector("div.error.c_skm");

  const err_clear = () => {
    for (let box of error_err_box_list) {
      box?.classList.remove("on");
    }
  };

  input_carnum?.select();
  input_carnum?.addEventListener("blur", async () => {
    err_clear();
    if (!err_massage(input_carnum, error_carnum, ERROR_MESSAGE.CARNUM)) {
      return false;
    }
    const carnum = input_carnum.value;
    const res = await fetch(`${rootPath}/car_check?carnum=${carnum}`);
    console.log();
    const json = await res.json();
    if (json.c_carnum === "NOT") {
      error_carnum.classList.add("on");
      error_carnum.innerHTML = "* 등록되지 않은 차량번호 입니다.";
      input_skm.value = "";
    } else {
      input_skm.value = json.c_ekm;
    }
  });
  input_qty?.addEventListener("blur", () => {
    err_clear();
    if (!err_massage(input_qty, error_qty, ERROR_MESSAGE.QTY)) {
      return false;
    }
  });
  input_username?.addEventListener("blur", () => {
    err_clear();
    if (!err_massage(input_username, error_username, ERROR_MESSAGE.USERNAME)) {
      return false;
    }
  });
  input_sdate?.addEventListener("blur", () => {
    err_clear();
    if (!err_massage(input_sdate, error_sdate, ERROR_MESSAGE.SDATE)) {
      return false;
    }
  });
  input_stime?.addEventListener("blur", () => {
    err_clear();
    if (!err_massage(input_stime, error_stime, ERROR_MESSAGE.STIME)) {
      return false;
    }
  });
  input_skm?.addEventListener("blur", () => {
    err_clear();
    if (!err_massage(input_skm, error_skm, ERROR_MESSAGE.SKM)) {
      return false;
    }
  });

  btn_save?.addEventListener("click", () => {
    if (
      err_massage(input_carnum, error_carnum, ERROR_MESSAGE.CARNUM) &&
      err_massage(input_qty, error_qty, ERROR_MESSAGE.QTY) &&
      err_massage(input_username, error_username, ERROR_MESSAGE.USERNAME) &&
      err_massage(input_sdate, error_sdate, ERROR_MESSAGE.SDATE) &&
      err_massage(input_stime, error_stime, ERROR_MESSAGE.STIME) &&
      err_massage(input_skm, error_skm, ERROR_MESSAGE.SKM)
    ) {
      document.querySelector("form.main").submit();
    }
    return false;
  });
});
