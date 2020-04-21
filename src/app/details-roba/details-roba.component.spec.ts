import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsRobaComponent } from './details-roba.component';

describe('DetailsRobaComponent', () => {
  let component: DetailsRobaComponent;
  let fixture: ComponentFixture<DetailsRobaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsRobaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsRobaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
