import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { AuthStateService } from '../auth/auth-state';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './layout.html',
  styleUrl: './layout.css',
})
export class LayoutComponent {

  constructor(
    private authState: AuthStateService,
    private router: Router
  ) {}

  logout() {
    this.authState.clear();
    this.router.navigate(['/login']);
  }
}
