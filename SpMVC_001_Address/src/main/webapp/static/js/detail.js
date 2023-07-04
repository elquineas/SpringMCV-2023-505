document.addEventListener("DOMContentLoaded", () => {
  const btn_list = document.querySelector("button.detail.list");
  const btn_update = document.querySelector("button.detail.update");
  const btn_delete = document.querySelector("button.detail.delete");

  btn_list?.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });

  btn_update?.addEventListener("click", (e) => {
    const id = e.target.dataset.id;
    document.location.replace(`${rootPath}/update?id=${id}`);
  });

  btn_delete?.addEventListener("click", (e) => {
    const btn = e.target;
    const id = btn.dataset.id;
    if (confirm("삭제한 데이터는 복구 할수 없습니다.\n정말 삭제할까요?")) {
      // 현재 화면이 뒤로가고 새로운 화면이 열리면서 response를 보여준다.
      // 뒤로가기를 클릭하면 이전 내용을 보여준다.
      // document.location.href = `${rootPath}/delete?id=${id}`;
      // document.location.replace( URL ) 로 요청을 하면
      // 현재화면에 서버로 전달받은 화면이 겹쳐서 표시된다.
      document.location.replace(`${rootPath}/delete?id=${id}`);
    }
  });
});
