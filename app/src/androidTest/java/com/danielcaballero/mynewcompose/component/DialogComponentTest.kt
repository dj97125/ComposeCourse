package com.danielcaballero.mynewcompose.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.danielcaballero.mynewcompose.components.AddTasksDialog
import org.junit.Rule
import org.junit.Test


class DialogComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetAtrue_thenShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {} )
        }

        composeTestRule.onNodeWithTag("test").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetFalse_thenDontShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = false, onDismiss = {}, onTaskAdded = {} )
        }

        composeTestRule.onNodeWithTag("test").assertDoesNotExist()
    }
}