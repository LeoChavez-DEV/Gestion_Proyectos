import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthStateService } from '../auth/auth-state';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class DashboardComponent {

   constructor(
    private authState: AuthStateService,
    private router: Router
  ) {}

  logout() {
    this.authState.clear();
    this.router.navigate(['/login']);
  }

}
