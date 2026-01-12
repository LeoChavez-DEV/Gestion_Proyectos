import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../auth';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class RegisterComponent {

    registerForm;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService
  ) {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  submit() {
    if (this.registerForm.invalid) return;

    const { email, password } = this.registerForm.value;

    this.authService.register(email!, password!).subscribe({
      next: () => {
        console.log('Registro OK');
      },
      error: (err) => {
        console.error('Registro error', err);
      }
    });
  }

}
