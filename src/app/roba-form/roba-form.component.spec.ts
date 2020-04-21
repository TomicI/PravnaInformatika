import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RobaFormComponent } from './roba-form.component';

describe('RobaFormComponent', () => {
  let component: RobaFormComponent;
  let fixture: ComponentFixture<RobaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RobaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RobaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
