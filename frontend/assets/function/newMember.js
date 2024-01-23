import { Member } from "../class/Member.js";

var newMember = document.getElementById("newMember");
var newMemberForm = document.getElementById("newMemberForm");
var submitForm = document.getElementById("submitForm");
var members = document.getElementById("members");
var addMember = document.getElementById("addMember");

var nameOfDancer = document.getElementById("nameOfDancer");
var lastNameOfDancer = document.getElementById("lastNameOfDancer");
var dateOfBirth = document.getElementById("dateOfBirth");

var membersList = [];
var id = 0;

newMember.addEventListener("click", toggleNewMemberForm);

addMember.addEventListener("click", function () {
  var member = new Member(
    id,
    nameOfDancer.value,
    lastNameOfDancer.value,
    dateOfBirth.value
  );
  membersList.push(member);

  localStorage.setItem("members", JSON.stringify(membersList));
  loadMemberList();
  toggleAddMember();
  id++;
});

function loadMemberList() {
  var storedMemberList = JSON.parse(localStorage.getItem("members"));

  storedMemberList.forEach((member) => {
    var exists = document.querySelector(".id-" + member.id);

    if (!exists) {
      var li = document.createElement("li");
      var firstDiv = document.createElement("div");
      var secondDiv = document.createElement("div");
      var firstP = document.createElement("p");
      var secondP = document.createElement("p");

      li.classList.add(
        "flex",
        "justify-between",
        "gap-x-6",
        "py-5",
        "id-" + member.id
      );
      firstDiv.classList.add("flex", "min-w-0", "gap-x-4");
      secondDiv.classList.add("min-w-0", "flex-auto");
      firstP.classList.add(
        "text-sm",
        "font-semibold",
        "leading-6",
        "text-gray-900"
      );
      secondP.classList.add(
        "mt-1",
        "truncate",
        "text-xs",
        "leading-5",
        "text-gray-500"
      );

      firstP.textContent = member.name + " " + member.lastName;
      secondP.textContent = member.dateOfBirth;

      secondDiv.appendChild(firstP);
      secondDiv.appendChild(secondP);

      firstDiv.appendChild(secondDiv);
      li.appendChild(firstDiv);
      members.appendChild(li);
    }
  });
}

function toggleNewMemberForm() {
  var active =
    newMember.getAttribute("aria-checked") === "true" ? "false" : "true";
  newMember.setAttribute("aria-checked", active);

  newMember.classList.add("hidden");
  submitForm.classList.add("hidden");
  newMemberForm.classList.remove("hidden");
}

function toggleAddMember() {
  var active =
    addMember.getAttribute("aria-checked") === "true" ? "false" : "true";
  addMember.setAttribute("aria-checked", active);

  newMember.classList.remove("hidden");
  submitForm.classList.remove("hidden");
  newMemberForm.classList.add("hidden");
}
