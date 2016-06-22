import {Component, View} from 'angular2/core';

@Component({
  selector: 'hello-angular-2'
})

@View({
  templateUrl: 'hello-angular-2.html'
})

export class HelloAngular2 {

  constructor() {
    console.info('HelloAngular2 Component Mounted Successfully');
  }

}
