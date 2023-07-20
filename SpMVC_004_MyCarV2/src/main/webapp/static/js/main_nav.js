document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");
  const nav_login = document.querySelector("li.login");
  const nav_join = document.querySelector("li.join");

  /*
    event 핸들러의 매개변수 (e)
    e.currentTarget과 e.target 속성이 기본으로 포함되어 있다
    이때 e.currentTarget 은 event 핸들러가 부착된 tag(nav.main) 이고
    e.target 은 event 버블링에 의해 가장 안쪽에서 실제 event가 적용되는 tag
  */
  const navClickHandler = (e) => {
    const current = e.currentTarget;
    const target = e.target;

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "login join mypage logout";
      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        // 문자열.indexOF("찾는문자열")
        // 문자열내에 찾는 문자열이 있으면 0이상의 위치값을 아니면 -1을 return ;

        // 문자열.search("찾는문자열")
        // 정규표현식 으로 문자열 찾기 가능
        URL = `${rootPath}user/` + targetClassName;
      }

      document.location.href = URL;

      //   else if (targetClassName === "mycar") {
      //     alert("My Car가기");
      //   } else if (targetClassName === "tacho") {
      //     alert("차량운행");
      //   }
    }
  };
  nav?.addEventListener("click", navClickHandler);
  //   nav_login?.addEventListener("click", () => {
  //     alert("로그인");
  //   });
  //   nav_login?.addEventListener("click", () => {
  //     alert("로그인 2");
  //   });
  //   nav_join?.addEventListener("click", () => {
  //     alert("회원가입");
  //   });
});
/*
    0, "", undefined, NaN, null 값이 if() 명령을 만나면
    이 값들은 false 로 취급된다

    const 변수 = 0;
    if(변수){
        console.log('이 값은 0이 아님 ${변수}');
    }else{
        console.log('이 값은 false로 취급 ${변수}');
    }

    const 변수1 = "";
    const 변수2;
    const 변수3 = 0;
    const 변수 = 변수1 && 변수2 && 변수3 && "몰라";
*/
