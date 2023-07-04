document.addEventListener("DOMContentLoaded", () => {
  const main_nav = document.querySelector("nav.main");

  const navClickHandler = (e) => {
    const nav_item = e.target;
    if (nav_item.tagName === "LI") {
      const nav_class = nav_item.className;
      const nav_classList = nav_item.classList;
      let location = `${rootPath}`;

      console.log("className : ", nav_class);

      if (nav_class === "home") {
        location += "/";
      }
      if (nav_classList.contains("user") > 0) {
        location += `/user/${nav_classList[1]}`;
      } else if (nav_class === "admin") {
        location += "/admin";
      }
      document.location.href = location;
      //   console.log("location : ", location);
      /*
      if (nav_class === "home") {
        location += `/`;
        // document.location.href = `${rootPath}/`;
      } else if (nav_class === "login") {
        location += `/user/login`;
      } else if (nav_class === "join") {
        location += `/user/join`;
        // document.location.href = `${rootPath}/user/join`;
      } else if (nav_class === "mypage") {
        location += `/user/mypage`;
        // document.location.href = `${rootPath}/user/mypage`;
      } else if (nav_class === "logout") {
        location += `/user/logout`;
        // document.location.href = `${rootPath}/user/logout`;
      } else if (nav_class === "admin") {
        location += `/admin`;
        // document.location.href = `${rootPath}/admin`;
      } else {
        location += "/";
      }
      */
    }
  };
  main_nav?.addEventListener("click", navClickHandler);
});
