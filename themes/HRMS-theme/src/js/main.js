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
    $(this).toggleClass("active");
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

 // Show loader when any AJAX starts
  $(document).ajaxStart(function () {
    $("#overlay").fadeIn(300);
  });

  // Hide loader when all AJAX requests complete
  $(document).ajaxStop(function () {
    setTimeout(function () {
      $("#overlay").fadeOut(300);
    }, 500);
  });

  $('.custom-select').select2();
  $('.custom-select').each(function () {
    const $select = $(this);
    const $select2Span = $select.next('.select2');

    if ($select2Span.length) {
      $select2Span.insertBefore($select);
    }
  });
  $('.custom-select').on('change', function () {
    if ($(this).data('select2')) {
      $(this).valid();
    }
  });
  $('.custom-multi-select').each(function () {
    $(this).select2({
      placeholder: $(this).attr('placeholder') || 'Select Options'
    });
  });

  // On select
  $('.custom-multi-select').on('select2:select', function (e) {
    const data = e.params.data;
    const $container = $('.selected-options');

    if ($container.find(`[data-id="${data.id}"]`).length === 0) {
      $container.append(`
        <span class="selected-option" data-id="${data.id}">
          ${data.text}
          <span class="remove">&times;</span>
        </span>
      `);
    }
  });

  $('.custom-multi-select').on('change', function () {
    const data = $(this).select2('data');
    const $container = $('.selected-options');

    // Clear and re-render outside options
    $container.empty();

    data.forEach(item => {
      $container.append(`
        <div class="selected-option" data-id="${item.id}">
          <span>${item.text}</span>
          <button class="remove">x</button>
        </div>
      `);
    });

    // Show only last selected item in input
    const last = data[data.length - 1];
    const $rendered = $(this)
      .next('.select2-container')
      .find('.select2-selection__rendered');

    $rendered.text(last ? last.text : '');
  });


  // Remove from outside container
  $(document).on('click', '.selected-option .remove', function () {
    const id = $(this).parent().data('id');
    const select = $('.custom-multi-select');

    const values = select.val().filter(val => val !== id.toString());
    select.val(values).trigger('change');
  });


  document.getElementById("copyright-year").textContent = new Date().getFullYear();
});

 // Hide loader after full page load
  $(window).on("load", function () {
    $("body").removeClass("page-loading");
    $("#overlay").fadeOut(300);
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
