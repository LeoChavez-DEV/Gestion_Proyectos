import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthStateService } from '../auth/auth-state';
import { ProjectService, Project } from '../projects/project';
import { FormsModule } from '@angular/forms';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  imports: [FormsModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class DashboardComponent implements OnInit {

  projects: Project[] = [];

  newProject = {
    name: '',
    description: ''
  };

  constructor(
    private authState: AuthStateService,
    private router: Router,
    private projectService: ProjectService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  goToProject(id: number) {
  this.router.navigate(['/projects', id]);
}

  loadProjects() {
  this.projectService.getProjects().subscribe({
    next: (data) => {
      console.log('Projects loaded:', data);

      this.projects = data;

      this.cdr.detectChanges(); 
    },
    error: (err) => {
      console.error('Error loading projects', err);
    }
  });
}

  createProject() {

    this.projectService.createProject(this.newProject).subscribe({
      next: (project) => {

        this.projects.push(project);

        this.newProject = {
          name: '',
          description: ''
        };

      },
      error: (err) => {
        console.error('Error creating project', err);
      }
    });
  }

  logout() {
    this.authState.clear();
    this.router.navigate(['/login']);
  }

}