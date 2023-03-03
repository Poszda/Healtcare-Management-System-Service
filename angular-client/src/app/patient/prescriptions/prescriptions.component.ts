import { Component, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-prescriptions',
  templateUrl: './prescriptions.component.html',
  styleUrls: ['./prescriptions.component.css']
})
export class PrescriptionsComponent implements OnDestroy{
  ngOnDestroy(): void {
    console.log('destroyed')
  }

}
