/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */
AUI().ready(function () {
  
  $(".header #toggle_btn").click(function () {
    $("body").toggleClass('collapsedMenu');
  });
  
  sidebarNavigation();


function sidebarNavigation() {
  $('.side_navbar > ul > li > .collapsed_icon').click(function () {
    $(".side_navbar > ul > li > ul > li.parent_sub_child").removeClass('active');
    $('.side_navbar > ul > li > ul > li > .collapsed_icon').removeClass('active');
    $(".side_navbar > ul > li > ul > li.parent_sub_child").removeClass('active');
    $('.side_navbar > ul > li > ul > li > .collapsed_icon').removeClass('active');
    if ($(this).parent('li').hasClass('active')) {
      $(this).parent('li').removeClass('active');
      $(this).removeClass('active');
    } else {
      if ($(".side_navbar > ul > li.parent").hasClass('active')) {
        $(".side_navbar > ul > li.parent").removeClass('active');
        $('.side_navbar > ul > li > .collapsed_icon').removeClass('active');
      }
      $(this).parent('li').addClass('active');
      $(this).addClass('active');
    }
  });
  childNavigation();

}

$('.slick-carousel').slick({
	  infinite: true,
	  speed: 500,
	  fade: true,
	  autoplay: true,
	  autoplaySpeed: 500,
	  cssEase: 'linear'
	});

function childNavigation() {
  $('.side_navbar > ul > li > ul > li > .collapsed_icon').click(function () {
    debugger;
    if ($(this).parent('li').hasClass('active')) {
      $(this).parent('li').removeClass('active');
      $(this).removeClass('active');
    } else {
      if ($(".side_navbar > ul > li > ul > li.parent_sub_child").hasClass('active')) {
        $(".side_navbar > ul > li > ul > li.parent_sub_child").removeClass('active');
        $('.side_navbar > ul > li > ul > li > .collapsed_icon').removeClass('active');
      }
      $(this).parent('li').addClass('active');
      $(this).addClass('active');
    }
  })
}
});

/*
 * This function gets loaded after each and every portlet on the page.
 *
 * portletId: the current portlet's id
 * node: the Alloy Node object of the current portlet
 */
Liferay.Portlet.ready(function (_portletId, _node) {});

/*
 * This function gets loaded when everything, including the portlets, is on
 * the page.
 */
Liferay.on('allPortletsReady', function () {});
