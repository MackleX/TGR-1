import { TestBed } from '@angular/core/testing';

import { JwtAuthManagerService } from './jwt-auth-manager.service';

describe('JwtAuthManagerService', () => {
  let service: JwtAuthManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtAuthManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
