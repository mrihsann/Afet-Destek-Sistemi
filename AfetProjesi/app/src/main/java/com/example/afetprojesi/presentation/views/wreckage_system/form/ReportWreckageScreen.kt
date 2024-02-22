package com.example.afetprojesi.presentation.views.wreckage_system.form

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.DescriptionInfo
import com.example.afetprojesi.presentation.views.general_ui.ErrorFormPage
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle
import com.example.afetprojesi.presentation.views.hook_assistance_system.form.PersonalInfo
import com.example.afetprojesi.presentation.views.hook_assistance_system.form.PhotoPicker
import com.example.afetprojesi.presentation.views.general_ui.SurveyBottomBar
import com.example.afetprojesi.presentation.views.general_ui.SurveyTopBar
import com.example.afetprojesi.presentation.views.help_system.form.LocationInfo
import com.example.afetprojesi.util.getTransitionDirection


@Composable
fun ReportWreckageScreen(
    onNavigateToHomePage: () -> Unit
) {

    // Sayfa değişimi için bir state değişkeni tanımlayalım
    val currentPageIndex = remember { mutableIntStateOf(0) }

    // Yönlendirme butonlarında hangisine tıklandığını kontrol ediyoruz
    val isClickedDirection = remember { mutableStateOf(false) }

    // Next butonunun etkin olup olmadığını takip eden değişken.
    val isNextButtonEnabled = remember { mutableStateOf(true) }

    // Previous butonunun gösterilip gösterilmeyeceğini takip eden değişken.
    val shouldShowPreviousButton = remember { mutableStateOf(false) }

    // Done butonunun gösterilip gösterilmeyeceğini takip eden değişken.
    val shouldShowDoneButton = remember { mutableStateOf(false) }

    // Done butonunun etkin olup olmadığını takip eden değişken.
    val isDoneButtonEnabled = remember { mutableStateOf(false) }

    // Seçilen resim URI'larını tutan liste.
    val selectedImageUris = remember { mutableStateOf<List<Uri>>(emptyList()) }


    //Sayfalardan gelen veriler burada tutuluyor
    val description = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val surname= remember { mutableStateOf("") }
    val number= remember { mutableStateOf("") }
    val city = remember { mutableStateOf("") }
    val district = remember { mutableStateOf("") }
    val neighbourhood = remember { mutableStateOf("") }
    val street = remember { mutableStateOf("") }
    val locationNot = remember { mutableStateOf("") }


    isDoneButtonEnabled.value =
        !(selectedImageUris.value.isEmpty()  or
                description.value.isEmpty() or
                name.value.isEmpty() or
                surname.value.isEmpty() or
                number.value.isEmpty() or
                city.value.isEmpty() or
                district.value.isEmpty() or
                neighbourhood.value.isEmpty() or
                street.value.isEmpty() or
                locationNot.value.isEmpty())

    val totalPageCount = 4
    Scaffold(
        topBar = {
            SurveyTopBar(
                questionIndex = currentPageIndex.intValue,
                totalQuestionsCount = totalPageCount,
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
                    // Eğer mevcut sayfa indeksi 3 değilse:
                    if (currentPageIndex.intValue != (totalPageCount-1)) {
                        // Bir sonraki butonu etkinleştir ve tamamlama butonunu gizle.
                        isNextButtonEnabled.value = true
                        shouldShowDoneButton.value = false
                    }
                    // Yönlendirme butonuna tıklama durumunu false yapar
                    isClickedDirection.value = false
                },
                onNextPressed = {
                    if ((currentPageIndex.intValue > -1) and (currentPageIndex.intValue < (totalPageCount-1))) {
                        // Mevcut sayfa indeksini bir artır ve önceki butonu göster.
                        currentPageIndex.intValue = currentPageIndex.intValue + 1
                        shouldShowPreviousButton.value = true
                    }
                    if (currentPageIndex.intValue == (totalPageCount-1)) {
                        // Bir sonraki butonu devre dışı bırak ve tamamlama butonunu göster.
                        isNextButtonEnabled.value = false
                        shouldShowDoneButton.value = true
                    }
                    // Yönlendirme butonuna tıklama durumunu true yapar.
                    isClickedDirection.value = true

                },
                onDonePressed = {
                    /*TODO(formu tamamlama butonuna tıklandığı zaman yapılacak işlemler burada olacak.)*/
                }
            )
        }
    ){ paddingValues ->
        //geçişli sayfa animasyonu için
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
            label = "surveyScreenDataAnimation"
        ){ animatedContentScope ->
            when (animatedContentScope) {
                0 -> {
                    PersonalInfo(name,surname,number,paddingValues)
                }
                1 -> {
                    PhotoPicker(selectedImageUris,paddingValues)
                }

                2 -> {
                    DescriptionInfo(description, paddingValues)
                }

                3 -> {
                    LocationInfo(
                        city = city,
                        district = district,
                        neighbourhood = neighbourhood,
                        street = street,
                        locationNot = locationNot,
                        paddingValues = paddingValues
                    )
                }

                else -> {
                    ErrorFormPage(paddingValues = paddingValues)
                }
            }
        }
    }
}