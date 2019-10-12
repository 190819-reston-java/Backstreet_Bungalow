import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularSectionComponent } from './popular-section.component';

describe('PopularSectionComponent', () => {
  let component: PopularSectionComponent;
  let fixture: ComponentFixture<PopularSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
