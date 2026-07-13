package com.drgabo.galaandroid.core.util

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


fun formatScheduledStartHour(scheduledStart: String): String {
    return OffsetDateTime.parse(scheduledStart)
        .format(DateTimeFormatter.ofPattern("HH:mm"))
}
//
//[
//{
//    "date": "2026-07-09",
//    "label": "jueves, 9 de julio",
//    "appointments": [
//    {
//        "id": "3d2245e8-2b50-4afe-9137-e2cfc7ac4c09",
//        "scheduledStart": "2026-07-09T16:00:00+00:00",
//        "scheduledEnd": "2026-07-09T16:45:00+00:00",
//        "appointmentStatus": "confirmed",
//        "paymentStatus": "unpaid",
//        "amountPaid": 0,
//        "remainingAmount": 200,
//        "source": "public_booking",
//        "ghostFlag": false,
//        "client": {
//        "id": "23e1f2be-9f4f-4646-ad2e-f57fb1f737a0",
//        "nombre": "Hhhh",
//        "telefono": "3885555633"
//    },
//        "serviceSummary": [
//        {
//            "serviceId": "553997a2-4b35-4b7f-a1e5-2fe1f294d9e9",
//            "nombre": "Corte de cabello",
//            "duracionMin": 45,
//            "precio": 200
//        }
//        ],
//        "businessTimezone": "America/Mazatlan",
//        "businessPaymentMode": "online",
//        "paymentUrl": null,
//        "notes": null,
//        "commercialStatus": "suspended",
//        "paymentSummary": {
//        "amountDue": 200,
//        "amountPaid": 0,
//        "remainingAmount": 200,
//        "receiptAvailable": false
//    },
//        "statusTimeline": {
//        "confirmedAt": "2026-07-08T20:50:35.539+00:00",
//        "paidAt": null,
//        "cancelledAt": null,
//        "closedAt": null
//    },
//        "cancellationReason": null
//    }
//    ]
//}
//]