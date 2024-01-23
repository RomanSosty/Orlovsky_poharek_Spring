export class ApplicationForm {
  constructor(
    groupName,
    contact,
    choreografiName,
    ageCategory,
    danceCategory,
    nameOfChoreografer,
    numOfDancer,
    lenghtOfDance,
    numOfDancerInGroup,
    meansOfTransport,
    message,
    members
  ) {
    this.groupName = groupName;
    this.contact = contact;
    this.choreografiName = choreografiName;
    this.ageCategory = ageCategory;
    this.danceCategory = danceCategory;
    this.nameOfChoreografer = nameOfChoreografer;
    this.numOfDancer = numOfDancer;
    this.lenghtOfDance = lenghtOfDance;
    this.numOfDancerInGroup = numOfDancerInGroup;
    this.meansOfTransport = meansOfTransport;
    this.message = message;
    this.members = members;
  }
}
