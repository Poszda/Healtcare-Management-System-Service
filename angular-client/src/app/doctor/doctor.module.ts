import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorRoutingModule } from './doctor-routing.module';
import { DoctorComponent } from './doctor.component';
import { SharedModule } from '../shared/shared.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { ProgramWidgetComponent } from './dashboard/program-widget/program-widget.component';
import { OverallstatusWidgetComponent } from './dashboard/overallstatus-widget/overallstatus-widget.component';
import { AppointmentsWidgetComponent } from './dashboard/appointments-widget/appointments-widget.component';
import { BarComponent } from './dashboard/bar/bar.component';
import { BookingRateWidgetComponent } from './dashboard/booking-rate-widget/booking-rate-widget.component';


@NgModule({
    declarations: [
        DoctorComponent,
        DashboardComponent,
        AppointmentsComponent,
        ProgramWidgetComponent,
        OverallstatusWidgetComponent,
        AppointmentsWidgetComponent,
        BarComponent,
        BookingRateWidgetComponent,
    ],
    imports: [
        CommonModule,
        DoctorRoutingModule,
        SharedModule,
    ]
})
export class DoctorModule { }
