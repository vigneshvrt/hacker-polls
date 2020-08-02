import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidateProfileComponent } from './candidate-profile/candidate-profile.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'profile/:id', component: CandidateProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
