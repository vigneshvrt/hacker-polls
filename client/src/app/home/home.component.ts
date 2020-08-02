import { Component, OnInit } from '@angular/core';
import { Candidate } from '../model/candidate.model';
import { AppService } from '../app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loading: boolean;
  candidates: Candidate[] = [];

  constructor(private appService: AppService) {
    this.loading = true;
    this.appService.getCandidates();
    this.appService.getCandidatesListener().subscribe(candidates => {
      this.loading = false;
      this.candidates = candidates;
      console.log(candidates);
    });
  }

  ngOnInit() {
  }
}
