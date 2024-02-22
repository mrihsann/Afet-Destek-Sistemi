package com.example.afetprojesi.presentation.views.hook_assistance_system.form

import android.net.Uri
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.ErrorFormPage
import com.example.afetprojesi.presentation.views.general_ui.SurveyBottomBar
import com.example.afetprojesi.presentation.views.general_ui.SurveyTopBar
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle
import com.example.afetprojesi.presentation.views.general_ui.SelectCategoryPage
import com.example.afetprojesi.util.getTransitionDirection

@Composable
fun HookAssistanceForm(
    onNavigateToHomePage: () -> Unit
) {

    // sayfa geçişlerinde, bulunduğumuz sayfanın index bilgisini burada tutuyoruz.
    val currentPageIndex = remember { mutableIntStateOf(0) }
    // Sayfalar arası geçişte efekt uygularken, hangi sayfaya yönlendirme olacağını burada ayarlıyoruz.
    val isClickedDirection = remember { mutableStateOf(false) }
    // Next butonunun etkin olup olmadığını takip eden değişken.
    val isNextButtonEnabled = remember { mutableStateOf(true) }
    // Previous butonunun gösterilip gösterilmeyeceğini takip eden değişken.
    val shouldShowPreviousButton = remember { mutableStateOf(false) }
    // Done butonunun gösterilip gösterilmeyeceğini takip eden değişken.
    val shouldShowDoneButton = remember { mutableStateOf(false) }
    // Done butonunun etkin olup olmadığını takip eden değişken.
    val isDoneButtonEnabled = remember { mutableStateOf(false) }


    //sayfalardan topladığımız veriler burada
    val selectedCategoryList = remember { mutableStateListOf<String>() }
    val selectedImageUris = remember { mutableStateOf<List<Uri>>(emptyList()) }
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val city = remember { mutableStateOf("") }
    val district= remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val surname= remember { mutableStateOf("") }
    val phoneNumber= remember { mutableStateOf("") }

    /*TODO(buraya apiden kategoriler gelecek ve buraya eklenecek.)*/
    val listCategory = remember{ mutableListOf("") }


    isDoneButtonEnabled.value =
        !(selectedCategoryList.isEmpty() or
                selectedImageUris.value.isEmpty() or
                title.value.isEmpty() or
                description.value.isEmpty() or
                city.value.isEmpty() or
                district.value.isEmpty() or
                name.value.isEmpty() or
                surname.value.isEmpty() or
                phoneNumber.value.isEmpty())


    Scaffold(
        topBar = {
            SurveyTopBar(
                questionIndex = currentPageIndex.intValue,
                totalQuestionsCount = 5,
                onClosePressed = onNavigateToHomePage,
            )
        },
        bottomBar = {
            SurveyBottomBar(
                shouldShowPreviousButton = shouldShowPreviousButton.value,
                shouldShowDoneButton = shouldShowDoneButton.value,
                isNextButtonEnabled = isNextButtonEnabled.value,
                isDoneButtonEnabled = isDoneButtonEnabled.value,
                onPreviousPressed = {
                    // Eğer mevcut sayfa indeksi 0'dan büyükse, bir önceki sayfaya git.
                    if (currentPageIndex.intValue > 0) {
                        currentPageIndex.intValue = currentPageIndex.intValue - 1
                    }
                    // Eğer mevcut sayfa indeksi 1'den küçükse, önceki butonu gizle.
                    if (currentPageIndex.intValue < 1) {
                        shouldShowPreviousButton.value = false
                    }
                    // Eğer mevcut sayfa indeksi 4 değilse:
                    if (currentPageIndex.intValue != 4) {
                        // Next butonunu etkinleştir ve done butonunu gizle.
                        isNextButtonEnabled.value = true
                        shouldShowDoneButton.value = false
                    }
                    //sayfa geçiş değişkenini false yap
                    isClickedDirection.value = false

                },
                onNextPressed = {
                    // Eğer mevcut sayfa indeksi -1 ile 4 arasındaysa:
                    if ((currentPageIndex.intValue > -1) and (currentPageIndex.intValue < 4)) {
                        // Mevcut sayfa indeksini bir artır ve önceki butonu göster.
                        currentPageIndex.intValue = currentPageIndex.intValue + 1
                        shouldShowPreviousButton.value = true
                    }
                    // Eğer mevcut sayfa indeksi 4 ise:
                    if (currentPageIndex.intValue == 4) {
                        // Bir sonraki butonu devre dışı bırak ve tamamlama butonunu göster.
                        isNextButtonEnabled.value = false
                        shouldShowDoneButton.value = true
                    }
                    //sayfa geçiş değişkenini true yap
                    isClickedDirection.value = true
                },
                onDonePressed = {
                    /*TODO(formu tamamlama butonuna tıklandığı zaman yapılacak işlemler burada olacak.)*/
                }
            )
        }
    ){ paddingValues ->
        //sayfa geçişlerinin animasyonlu olması için
        AnimatedContent(
            targetState = currentPageIndex.intValue,
            transitionSpec = {
                val animationSpec: TweenSpec<IntOffset> = tween(300)

                val direction = getTransitionDirection(
                    initialIndex = if (isClickedDirection.value){ currentPageIndex.intValue - 1} else {
                        currentPageIndex.intValue +1
                    },
                    targetIndex = if (isClickedDirection.value){ currentPageIndex.intValue + 1} else {
                        currentPageIndex.intValue -1
                    },
                )
                slideIntoContainer(
                    towards = direction,
                    animationSpec = animationSpec,
                ) togetherWith slideOutOfContainer(
                    towards = direction,
                    animationSpec = animationSpec
                )
            },
            label = "ScreenDataAnimation"
        ){ animatedContentScope ->
            when (animatedContentScope) {
                0 -> {
                    SelectCategoryPage(listCategory = listCategory,selectedCategoryList=selectedCategoryList, paddingValues=paddingValues)
                }
                1 -> {
                    PhotoPicker(selectedImageUris,paddingValues)
                }
                2 -> {
                    AboutItem(title,description,paddingValues)
                }
                3 -> {
                    Location(city,district,paddingValues)
                }
                4 -> {
                    PersonalInfo(name,surname,phoneNumber,paddingValues)
                }
                else -> {
                    ErrorFormPage(paddingValues = paddingValues)
                }
            }
        }
    }
}

