package com.example.afetprojesi

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.afetprojesi.presentation.views.help_system.form.HelpFormScreen
import com.example.afetprojesi.presentation.views.help_system.list.HelpList
import com.example.afetprojesi.presentation.views.home_page.HomePage
import com.example.afetprojesi.presentation.views.hook_assistance_system.list.HookAssistance
import com.example.afetprojesi.presentation.views.hook_assistance_system.form.HookAssistanceForm
import com.example.afetprojesi.presentation.views.hook_assistance_system.detail.DetailPage
import com.example.afetprojesi.presentation.views.help_system.detail.DetailRequest
import com.example.afetprojesi.presentation.views.wreckage_system.detail.DetailWreckage
import com.example.afetprojesi.presentation.views.wreckage_system.list.ListOfWreckages
import com.example.afetprojesi.presentation.views.wreckage_system.form.ReportWreckageScreen
import com.example.afetprojesi.presentation.views.wreckage_system.form_helper.GoHelpToWreckage

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page") {
        composable(route="home_page") { HomePage(navController) }
        composable(route="help_form") { HelpFormScreen(navController) }

        composable(
            route="help_detail/{id}",
            arguments=listOf(navArgument(name = "id"){
            type= NavType.StringType
        })) {
            DetailRequest(onNavigateToPopBack = {navController.popBackStack()},it.arguments?.getString("id")) }

        composable(route="help_list") { HelpList(navController)}
        composable(route="hanger_list") { HookAssistance(navController) }
        composable(route="hanger_detail") { DetailPage(navController)}
        composable(route="hanger_form") { HookAssistanceForm(navController) }
        composable(route="wreckage_form") { ReportWreckageScreen(navController) }
        composable(route="wreckage_report_team") { GoHelpToWreckage(navController) }
        composable(route="wreckage_detail") { DetailWreckage(navController)}
        composable(route="wreckage_list") { ListOfWreckages(navController) }
    }
}

