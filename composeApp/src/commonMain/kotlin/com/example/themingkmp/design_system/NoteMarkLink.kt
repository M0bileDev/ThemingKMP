package com.example.themingkmp.design_system

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.themingkmp.theme.NoteAppTheme

@Composable
fun NoteMarkLink(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier.clickable(onClick = onClick),
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewNoteMarkLinkLight(){
    NoteAppTheme(darkTheme = false){
        NoteMarkLink("Super link", onClick = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkLinkDark(){
    NoteAppTheme(darkTheme = true){
        NoteMarkLink("Super link", onClick = {})
    }
}