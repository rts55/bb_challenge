$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/rjs55/features/newTest.feature");
formatter.feature({
  "line": 1,
  "name": "A simple feature structure",
  "description": "\nThis feature outlines basic structure of a cucumber test",
  "id": "a-simple-feature-structure",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1570296927,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "This scenario demonstrates searching something",
  "description": "",
  "id": "a-simple-feature-structure;this-scenario-demonstrates-searching-something",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I require information about \"Test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I search for the given subject",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I will be shown some real interesting stuff",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 29
    }
  ],
  "location": "SearchSteps.iRequireInformationAbout(String)"
});
formatter.result({
  "duration": 170792590,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.iSearchForTheGivenSubject()"
});
formatter.result({
  "duration": 801906509,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.iWillBeShownSomeRealInterestingStuff()"
});
formatter.result({
  "duration": 349724529,
  "status": "passed"
});
formatter.after({
  "duration": 6669911,
  "status": "passed"
});
});