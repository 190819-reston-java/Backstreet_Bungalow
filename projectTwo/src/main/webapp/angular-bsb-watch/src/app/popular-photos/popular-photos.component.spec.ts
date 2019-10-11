import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularPhotosComponent } from './popular-photos.component';

describe('PopularPhotosComponent', () => {
  let component: PopularPhotosComponent;
  let fixture: ComponentFixture<PopularPhotosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularPhotosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularPhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
