import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleUserPhotosComponent } from './single-user-photos.component';

describe('SingleUserPhotosComponent', () => {
  let component: SingleUserPhotosComponent;
  let fixture: ComponentFixture<SingleUserPhotosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleUserPhotosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleUserPhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
