//顶部category菜单
(function ($) {
    var methods = {
        init: function (options) {
            var $this = $(this)
            var obj = $(this).data('tooltip').obj
            if (obj.textList) {
                $.each(obj.textList, function (index, value) {
                    $this.append('<li>' + index + '</li>')
                })
            }
            if (obj.width) {
                $this.find('li').css('width', obj.width + 'px')
                $this.find('.sideline').css('width', obj.width + 'px')
            }
            if (obj.height) {
                $this.css('height', obj.height + 'px')
                $this.find('li').css('height', obj.height + 'px')
                $this.find('li').css('line-height', obj.height + 'px')
                $this.find('.sideline').css('height', obj.height + 'px')
            }
            if (obj.default) {
                $this.find('.sideline').css('left', obj.width ? (obj.default - 1) * obj.width + 'px' : (obj.default - 1) * 100 + 'px')
            }
        }, fontUp: function () {
            var $this = $(this);
            $this.find('li').on('click', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'fontNav')
            }).on('hover', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'fontNav')
            })
        }, downUp: function () {
            var $this = $(this);
            $this.find('li').on('click', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'downNav')
            }).on('hover', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'downNav')
            })
        }, slideMove: function () {
            var $this = $(this)
            var obj = $(this).data('tooltip').obj
            $this.find('li').on('click', function () {
                if (($this.find('.sideline').is(":hidden"))) {
                    $this.find('.sideline').show()
                }
                var left = obj.width ? ($(this).index() * obj.width) + 'px' : ($(this).index() * 100) + 'px'
                console.log($(this).index());
                switch ($(this).index()) {
                    case 0:setTimeout(window.location.href='main',3000);
                    break;
                    case 1:setTimeout(window.location.href="viewCategory?categoryId=FISH",3000);
                    break;
                    case 2:setTimeout(window.location.href="viewCategory?categoryId=DOGS",3000);
                    break;
                    case 3:setTimeout(window.location.href="viewCategory?categoryId=CATS",3000);
                    break;
                    case 4:setTimeout(window.location.href="viewCategory?categoryId=REPTILES",3000);
                    break;
                    case 5:setTimeout(window.location.href="viewCategory?categoryId=BIRDS",3000);
                    break;
                }

                $this.find('.sideline').animate({'left': left})
            })
        }, edgeLeft: function () {
            var $this = $(this)
            $this.find('li').on('click', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'edgeLeft')
            }).on('hover', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'edgeLeft')
            })
        }, edgeRight: function () {
            var $this = $(this)
            $this.find('li').on('click', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'edgeRight')
            }).on('hover', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'edgeRight')
            })
        }, scaleChange: function () {
            var $this = $(this)
            $this.find('li').on('click', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'scaleChange')
            }).on('hover', function () {
                $this.find('li').attr('class', '')
                $this.find('.sideline').hide()
                this.setAttribute('class', 'scaleChange')
            })
        }
    };
    $.fn.tooltip = function (method) {
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            if (method.type) {
                var $this = $(this);
                $(this).data('tooltip', {target: $this, obj: method});
                methods.init.apply(this, arguments);
                methods[method.type].apply(this, Array.prototype.slice.call(arguments, 1));
                return method.success ? method.success(this) : null
            } else {
                return methods.init.apply(this, arguments);
            }
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.tooltip');
        }
    };
})(jQuery);

//悬浮提示 mtip
var mTips = {
    c: {
        x: 10,
        y: 10,
        style: {
            'position': 'fixed',
            'padding': '8px 12px',
            'color': '#fff',
            'border-radius': '5px',
            'font-family': "微软雅黑",
            'z-index': '999',
            'display': 'inline',
            'font-size': '14px',
            'background-color': 'rgba(0, 0, 0, 0.5)',
            'color': '#fff'
        }
    }, s: function (text, a, b) {
        var style;
        var fun;
        if (typeof(a) == 'string') {
            style = a;
            fun = b;
        } else if (typeof(a) == 'function') {
            style = b;
            fun = a;
        }
        if (style == 'undefined' || style == null) {
            style = 'default';
        }
        var doc = $('<div></div>').addClass('mTips mTips-' + style).html(text).appendTo('body');
        if (doc.css('z-index') !== '999') {
            doc.css(this.c.style);
        }
        $(document).on('mousemove', function (e) {
            $(".mTips").offset({top: e.pageY + mTips.c.x, left: e.pageX + mTips.c.y})
        });
        if (fun != null && typeof(fun) != 'undefined') {
            fun();
        }
    }, h: function (fun) {
        $('.mTips').remove();
        if (fun != 'undefined' && fun != null) {
            fun();
        }
    }, m: function () {
        $(document).on('mouseenter', '[data-mtpis]', function (e) {
            mTips.s($(this).attr('data-mtpis'), $(this).attr('data-mtpis-style'));
        });
        $(document).on('mouseleave', '[data-mtpis]', function (e) {
            mTips.h();
        });
    }
}
mTips.m();


