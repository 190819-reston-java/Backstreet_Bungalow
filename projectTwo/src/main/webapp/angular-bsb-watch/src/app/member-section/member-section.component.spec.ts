import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberSectionComponent } from './member-section.component';

describe('MemberSectionComponent', () => {
  let component: MemberSectionComponent;
  let fixture: ComponentFixture<MemberSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
