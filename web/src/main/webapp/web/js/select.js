var openSelect = null;
// Init
$(function() {
	$("select.select").each(function() {
		var i = $(this);
		var list = [];
		var label = "";
		i.children().each(function() {
			var tagName = String($(this)[0].tagName).toUpperCase();
			if(tagName == "OPTION") {
				list.push($(this));
			} else if(tagName == "OPTGROUP") {
				var subList = { label:$(this).attr("label"), img:$(this).attr("img"), children:$(this).children() };
				list.push(subList);
			}
		});
		
		var sName = $(this).attr("name"); 
		var html = "<div class=\"select span-5\" >";
		html+= "<input type=\"hidden\" name=\"" + sName + "\" value=\"" + list[0].val() + "\" />";
		html+= "<div class=\"label\" ></div>";
		html+= "<div class=\"button\" ><img src=\"../img/arrow.png\" width=\"16\" height=\"16\" /></div>";
		html+= "<div class=\"list hide\" >";
		for(var node in list) {
			if(list[node].label != undefined) {
				var img = "";
				if(list[node].img != undefined) {
					img = "<img src=\"" + list[node].img + "\" />";
				}
				html+= "<div class=\"optgroup span-5 last\" >" + img + list[node].label + "</div>";
				list[node].children.each(function() {
					var img = "";
					if($(this).attr("img")) {
						img = "<img src=\"" + $(this).attr("img") + "\" />";
					}
					var selected = "";
					if($(this).attr("selected")) {
						selected = "selected=\"selected\"";
						label = img + $(this).html();
					}
					html+= "<div class=\"option span-5 last\" " + selected + " val=\"" + $(this).val() + "\">" + img + $(this).html() + "</div>";
				});
			} else {
				var img = "";
				if(list[node].attr("img") != undefined) {
					img = "<img src=\"" + list[node].attr("img") + "\" />";
				}
				var selected = "";
				if(list[node].attr("selected")) {
					selected = "selected=\"selected\"";
					label = img + list[node].html();
				}
				html+= "<div class=\"option span-5 last\" " + selected + " val=\"" + list[node].val() + "\">" + img + list[node].html() + "</div>";
			}
		}
		html+= "</div>";
		html+= "</div>";
		html = $(html);
		i.replaceWith(html);
		html.data("state", "close");
		var list = html.children(".list");
		// Try to get selected
		if(!label) {
			label = list.children().first().html();
		}
		list.children(".option").last().addClass("bottom");
		html.children(".label").html(label);
		list.children(".option").click(function() {
			html.children("input[name='" + sName + "']").val($(this).attr("val"));
			html.children(".label").html($(this).html());
		});
		html.click(function(event) {
			if($(this).data("state") == "close") {
				$(this).children(".button").addClass("active");
				list.slideDown(125, function() {
					html.data("state", "open");
				});
			}
		});
		$(document).click(function(event) {
			if(html.data("state") == "open") {
				$(html).children(".button").removeClass("active");
				list.hide();
				html.data("state", "close");
			}
		});
	});
});