document.addEventListener("DOMContentLoaded", () => {
  const table_list = document.querySelectorAll("div.table_box > div");
  //   console.log(table_list);

  const tableClickHandler = (e) => {
    const target_table = e.target;
    console.log(target_table.innerHTML);
    const table_num = target_table.innerHTML;
    if (target_table.tagName !== "DIV") {
      return false;
    }
    const url = `${rootPath}/order?table_num=${table_num}`;
    window.location.href = url;
  };

  for (const table of table_list) {
    // console.log(table);
    table?.addEventListener("click", tableClickHandler);
  }
});
