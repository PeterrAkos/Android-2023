package com.example.android.model



data class InstructionDTO(
    val instructionID: Int,
    val displayText: String,
    val position: Int
)

// Konverziós függvény InstructionDTO -> InstructionModel
fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.instructionID,
        displayText = this.displayText,
        position = this.position
    )
}
