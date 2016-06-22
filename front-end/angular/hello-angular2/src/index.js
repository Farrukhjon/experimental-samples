import {Component, View} from 'angular2/core';
import {bootstrap} from 'angular2/platform/browser';
import {HelloAngular2} from 'hello-angular-2';

@Component({
  selector: 'main'
})

@View({
  directives: [HelloAngular2],
  template: `
    <hello-angular-2></hello-angular-2>
  `
})

class Main {

}

bootstrap(Main);
