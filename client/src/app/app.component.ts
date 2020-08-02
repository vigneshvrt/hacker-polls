import { Component } from '@angular/core';
import { Candidate } from './model/candidate.model';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hacker-polls';

  constructor() {}
}
