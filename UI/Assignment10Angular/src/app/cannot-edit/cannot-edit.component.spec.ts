import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CannotEditComponent } from './cannot-edit.component';

describe('CannotEditComponent', () => {
  let component: CannotEditComponent;
  let fixture: ComponentFixture<CannotEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CannotEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CannotEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
