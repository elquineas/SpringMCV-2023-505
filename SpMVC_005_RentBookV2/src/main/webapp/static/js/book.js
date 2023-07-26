document.addEventListener("DOMContentLoaded", () => {
  const input_bname = document.querySelector("input#b_name");
  const input_bcode = document.querySelector("input#rent_bcode");
  const input_bcomp = document.querySelector("input#b_comp");
  const result_list = document.querySelector("div.search.list");

  const result_listClickHandler = (e) => {
    const book_item = e.target;
    if (book_item.tagName !== "DIV") {
      return false;
    }

    input_bcode.value = book_item.dataset.bcode;
    input_bcomp.value = book_item.dataset.bcomp;
    input_bname.value = book_item.dataset.bname;
    result_list.style.display = "none";
  };
  result_list?.addEventListener("click", result_listClickHandler);

  const bnameSearch = async (e) => {
    const bname = e.target.value;
    if (bname.length < 2) {
      result_list.style.display = "none";
      return false;
    }
    result_list.style.display = "block";
    const url = `${rootPath}/book/name/search?b_name=${bname}`;
    const response = await fetch(url);
    const result = await response.json();
    // console.log(result);
    result_list.innerHTML = "";
    result.forEach((book) => {
      // console.table(book);
      const book_item = document.createElement("div");
      book_item.innerHTML = `${book.b_name} : ${book.b_comp} : ${book.b_auther}`;
      // book_item.innerHTML.replace

      book_item.dataset.bcode = book.b_code;
      book_item.dataset.bcomp = book.b_comp;
      book_item.dataset.bname = book.b_name;

      result_list.appendChild(book_item);
    });
  };
  input_bname?.addEventListener(
    "keyup",
    debounce((e) => {
      bnameSearch(e);
    })
  );
});
