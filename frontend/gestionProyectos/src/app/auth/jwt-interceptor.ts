import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthStateService } from './auth-state';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {

  const authState = inject(AuthStateService);
  const token = authState.getToken();

  if (token) {

    const clonedRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });

    return next(clonedRequest);
  }

  return next(req);
};