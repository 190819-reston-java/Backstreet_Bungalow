import { TestBed } from '@angular/core/testing';

import { MapsHttpService } from './maps-http.service';

describe('MapsHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MapsHttpService = TestBed.get(MapsHttpService);
    expect(service).toBeTruthy();
  });
});
