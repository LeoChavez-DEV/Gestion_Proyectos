import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { AuthStateService } from '../auth/auth-state';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet, RouterModule, CommonModule],
  templateUrl: './layout.html',
  styleUrl: './layout.css',
})


export class LayoutComponent {

  constructor(
    public authState: AuthStateService,
    private router: Router
  ) {}

        get currentUrl() {
      return this.router.url;
    }

  logout() {
    this.authState.clear();
    this.router.navigate(['/login']);
  }



}