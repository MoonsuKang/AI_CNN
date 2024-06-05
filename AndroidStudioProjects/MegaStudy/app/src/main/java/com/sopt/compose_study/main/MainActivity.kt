package com.sopt.compose_study.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.compose_study.ui.theme.ViewModelTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TopLevel()
                }
            }
        }
    }
}

class TodoViewModel : ViewModel() {
    val text = mutableStateOf("")
    val toDoList = mutableStateListOf<ToDoData>()

    // 리스트 추가
    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1 // 새로운 아이템의 키 생성. 마지막 아이템 키 +1
        toDoList.add(ToDoData(key, it)) // 리스트에 추가
        text.value = ""

    }

    // 수정
    val onEdit: (Int, String) -> Unit = { key, newText ->
        val i = toDoList.indexOfFirst { it.key == key } // index찾기
        toDoList[i] = toDoList[i].copy(text = newText) // update
    }

    // 완료 상태 토글
    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { it.key == key } // index찾기
        toDoList[i] = toDoList[i].copy(done = checked) // 완료상태 update
    }

    // 삭제
    val onDelete: (Int) -> Unit = { key ->
        val i = toDoList.indexOfFirst { it.key == key } //index찾기
        toDoList.removeAt(i) // 삭제
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopLevel(viewModel: TodoViewModel = viewModel()) {
    Scaffold {
        Column {
            // 사용자 입력 component
            ToDoInput(
                text = viewModel.text.value,
                onTextChange = { viewModel.text.value = it },
                onSubmit = viewModel.onSubmit
            )
            // 리스트 component
            LazyColumn {
                items(
                    items = viewModel.toDoList,
                    key = { it.key } // 각 항목 키 지정
                ) { toDoData ->
                    // 아이템 표시 component
                    ToDo(
                        toDoData = toDoData,
                        onEdit = viewModel.onEdit,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete
                    )
                }
            }
        }
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ViewModelTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Crossfade(
            targetState = isEditing,
        ) {
            when (it) {
                false -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text("완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )
                        Button(
                            onClick = { isEditing = true }
                        ) {
                            Text("수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(
                            onClick = { onDelete(toDoData.key) }
                        ) {
                            Text("삭제")
                        }
                    }
                }

                true -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val (text, setText) = remember { mutableStateOf(toDoData.text) }
                        OutlinedTextField(
                            value = text,
                            onValueChange = setText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Button(onClick = {
                            isEditing = false
                            onEdit(toDoData.key, text)
                        }) {
                            Text("완료")
                        }
                    }
                }
            }
        }
    }
}


data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)