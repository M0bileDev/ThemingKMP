package com.example.themingkmp.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themingkmp.theme.NoteAppTheme

@Composable
fun NoteMarkButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        contentPadding = PaddingValues(12.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun PreviewNoteMarkButton() {
    NoteAppTheme(darkTheme = false) {
        NoteMarkButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Create account",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun PreviewNoteMarkButtonDark() {
    NoteAppTheme(darkTheme = true) {
        NoteMarkButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Create account",
            onClick = {}
        )
    }
}