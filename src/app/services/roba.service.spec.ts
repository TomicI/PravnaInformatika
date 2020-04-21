import { TestBed, inject } from '@angular/core/testing';

import { RobaService } from './roba.service';

describe('RobaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RobaService]
    });
  });

  it('should be created', inject([RobaService], (service: RobaService) => {
    expect(service).toBeTruthy();
  }));
});
