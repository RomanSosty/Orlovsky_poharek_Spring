var policiesButton = document.getElementById("policiesButton");
var policiesSpan = document.getElementById("policiesSpan");

policiesButton.addEventListener("click", function () {
  var active =
    policiesButton.getAttribute("aria-checked") === "true" ? "false" : "true";
  policiesButton.setAttribute("aria-checked", active);

  if (active) {
    policiesButton.classList.toggle("bg-indigo-600");
    policiesSpan.classList.toggle("translate-x-3.5");
  }
});
