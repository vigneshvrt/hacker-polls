import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Candidate } from './model/candidate.model';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private candidatesUpdated = new Subject<Candidate[]>();

  constructor(private http: HttpClient) { }

  getCandidates() {
    this.http.get<Candidate[]>('/api/candidate')
    .subscribe(response => {
      this.candidatesUpdated.next([...response]);
    });
  }

  getCandidateDetails(candidateId): Promise<Candidate> {
    return this.http.get<Candidate>('/api/candidate/' + candidateId).toPromise();
  }

  getCandidatesListener() {
    return this.candidatesUpdated.asObservable();
  }

  addVote(candidateId: number): Promise<any> {
    return this.http.post('/api/vote/add', {candidateId}).toPromise();
  }
}
