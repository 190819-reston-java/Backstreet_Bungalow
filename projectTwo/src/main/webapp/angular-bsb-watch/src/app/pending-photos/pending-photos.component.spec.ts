import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingPhotosComponent } from './pending-photos.component';

describe('PendingPhotosComponent', () => {
  let component: PendingPhotosComponent;
  let fixture: ComponentFixture<PendingPhotosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingPhotosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingPhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
