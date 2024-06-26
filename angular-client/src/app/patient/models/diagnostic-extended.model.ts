import { Medication } from "./medication.model"

export interface DiagnosticExtended{
    id : number
    diagnostic : string,
    createdAt : string
    doctorId : string,
    doctorFirstName: string
    doctorLastName: string
    description: string
    date: string
    procedure: string
    speciality: string
    hospital: string
    doctorProfileImage?: string
    medications : Medication[]
}