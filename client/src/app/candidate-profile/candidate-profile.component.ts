import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppService } from '../app.service';
import { Candidate } from '../model/candidate.model';

@Component({
  selector: 'app-candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent implements OnInit {

  candidate: Candidate;
  loading: boolean;
  status: string;
  remarks: string;
  candidateId: number;

  constructor(private route: ActivatedRoute, private service: AppService) {
    this.loading = true;
    this.route.params.subscribe(params => {
      this.candidateId = params.id;
      this.updateCandidateDetails();
    });
  }

  updateCandidateDetails() {
    this.loading = true;
    this.service.getCandidateDetails(this.candidateId)
      .then(response => {
        this.candidate = response;
        this.loading = false;
      });
  }

  ngOnInit() {
  }

  addVote() {
    this.service.addVote(this.candidate.id).then(response => {
      this.status = 'success';
      this.remarks = 'Successfully voted!';
      this.updateCandidateDetails();
    }).catch(response => {
      this.status = 'failed';
      this.remarks = response.error.errMsg;
    });
  }
}
