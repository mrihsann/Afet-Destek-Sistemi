package com.example.afetprojesi.presentation.views.help_system.form

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
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle
import com.example.afetprojesi.presentation.views.general_ui.SurveyBottomBar
import com.example.afetprojesi.presentation.views.general_ui.SurveyTopBar
import com.example.afetprojesi.presentation.views.general_ui.DescriptionInfo
import com.example.afetprojesi.presentation.views.general_ui.ErrorFormPage
import com.example.afetprojesi.presentation.views.general_ui.SelectCategoryPage
import com.example.afetprojesi.util.getTransitionDirection

@Composable
fun HelpFormScreen(onNavigateToHomePage: () -> Unit) {

    // Sayfa değişimi sırasında, mevcut sayfanın konumunu burada tutuyoruz
    val currentPageIndex = remember { mutableIntStateOf(0) }
    // Bu değişken, sayfa geçişi sırasında sağa mı yoksa sola mı gideceğini takip etmek için oluşturuldu.
    val isClickedDirection = remember { mutableStateOf(false) }
    // Bu değişken, bir sonraki butonun etkin olup olmadığını takip eder.
    val isNextButtonEnabled = remember { mutableStateOf(true) }
    // Bu değişken, tamamlama butonunun etkin olup olmadığını takip eder.
    val isDoneButtonEnabled = remember { mutableStateOf(false) }
    // Bu değişken, önceki butonun gösterilip gösterilmeyeceğini takip eder.
    val shouldShowPreviousButton = remember { mutableStateOf(false) }
    // Bu değişken, tamamlama butonunun gösterilip gösterilmeyeceğini takip eder.
    val shouldShowDoneButton = remember { mutableStateOf(false) }

    //Sayfalardan gelen verileri aşağıda tutuyoruz
    val selectedCategoryList = remember { mutableStateListOf<String>() }
    val tc = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val surname = remember { mutableStateOf("") }
    val number = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val city = remember { mutableStateOf("") }
    val district = remember { mutableStateOf("") }
    val neighbourhood = remember { mutableStateOf("") }
    val street = remember { mutableStateOf("") }
    val locationNot = remember { mutableStateOf("") }

    //eğer boş veri varsa done butonunu devre dışı bırakıyoruz
    isDoneButtonEnabled.value =
        !(selectedCategoryList.isEmpty() or
                tc.value.isEmpty() or
                name.value.isEmpty() or
                surname.value.isEmpty() or
                number.value.isEmpty() or
                description.value.isEmpty() or
                city.value.isEmpty() or
                district.value.isEmpty() or
                neighbourhood.value.isEmpty() or
                street.value.isEmpty() or
                locationNot.value.isEmpty())
    /*TODO(buraya apiden kategoriler gelecek ve buraya eklenecek.)*/
    val listCategory = remember{ mutableListOf("") }

    val totalPageCount=4


    Scaffold(
        topBar = {
            SurveyTopBar(
                questionIndex = currentPageIndex.intValue,
                totalQuestionsCount = totalPageCount,
                onClosePressed = {onNavigateToHomePage()},
            )
        },
        bottomBar = {
            SurveyBottomBar(
                shouldShowPreviousButton = shouldShowPreviousButton.value,
                shouldShowDoneButton = shouldShowDoneButton.value,
                isNextButtonEnabled = isNextButtonEnabled.value,
                isDoneButtonEnabled = isDoneButtonEnabled.value,
                onPreviousPressed = {
                    // Eğer mevcut sayfa indeksi 0'dan büyükse, bir önceki sayfaya gidebilir.
                    if (currentPageIndex.intValue > 0) {
                        currentPageIndex.intValue = currentPageIndex.intValue - 1
                    }

                    // Eğer mevcut sayfa indeksi 1'den küçükse, önceki sayfa olmayacağı için, geri butonu gizlenecek
                    if (currentPageIndex.intValue < 1) {
                        shouldShowPreviousButton.value = false
                    }

                    // Eğer mevcut sayfa indeksi 3 değilse:
                    if (currentPageIndex.intValue != (totalPageCount-1)) {
                        // Bir sonraki butonu etkinleştir.
                        isNextButtonEnabled.value = true
                        // Tamamlama butonunu gizle.
                        shouldShowDoneButton.value = false
                    }

                    // Yönlendirme butonunu false yapar yani sayfa geçiş animasyonu sağa doğru olacak
                    isClickedDirection.value = false
                },
                onNextPressed = {
                    // Eğer mevcut sayfa indeksi -1 ile 4 arasındaysa:
                    if ((currentPageIndex.intValue > -1) and (currentPageIndex.intValue < totalPageCount)) {
                        // Mevcut sayfa indeksini bir artır ve önceki butonu göster.
                        currentPageIndex.intValue = currentPageIndex.intValue + 1
                        shouldShowPreviousButton.value = true
                    }
                    // Eğer mevcut sayfa indeksi 3 ise:
                    if (currentPageIndex.intValue == (totalPageCount-1)) {
                        // Bir sonraki butonu devre dışı bırak ve tamamlama butonunu göster.
                        isNextButtonEnabled.value = false
                        shouldShowDoneButton.value = true
                    }
                    // Yönlendirme butonunu true yapar yani sayfa geçiş animasyonu sola doğru olacak
                    isClickedDirection.value = true

                },
                onDonePressed = {
                    /*TODO(formu tamamlama butonuna tıklandığı zaman yapılacak işlemler burada olacak.)*/
                }
            )
        }
    ){ paddingValues ->
        //sayfa değişimi sırasında animasyon ile hareket olmasını sağlıyoruz
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
                //sayfa indisine göre hangi sayfanın açılacağını sağlıyoruz
                0 -> {
                    PersonalInfoHelpPage(tc = tc, name = name, surname = surname,number=number,paddingValues=paddingValues)
                }
                1 -> {
                    SelectCategoryPage(listCategory = listCategory,
                        selectedCategoryList=selectedCategoryList,
                        paddingValues=paddingValues)
                }
                2 -> {
                    DescriptionInfo(description = description, paddingValues = paddingValues)
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
