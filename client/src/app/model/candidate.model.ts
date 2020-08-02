export interface Candidate {

  id: number;
  name: string;
  challengesSolved: number;
  rating: number;
  expertises: {skill: string, rating: number};
  totalVotes: number;
}
