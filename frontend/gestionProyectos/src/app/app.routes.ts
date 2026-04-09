import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login';
import { RegisterComponent } from './auth/register/register';
import { DashboardComponent } from './dashboard/dashboard';
import { LayoutComponent } from './layout/layout';
import { authGuard } from './auth/auth-guard';
import { ProjectDetailComponent } from './projects/project-detail/project-detail';



export const routes: Routes = [

  {
    path: '',
    component: LayoutComponent,
    children: [

      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'dashboard', component: DashboardComponent, canActivate: [authGuard] },
      { path: 'projects/:id', component: ProjectDetailComponent, canActivate: [authGuard] },

      { path: '', redirectTo: 'login', pathMatch: 'full' },
      

    ]
  },

  { path: '**', redirectTo: 'login' }

];
